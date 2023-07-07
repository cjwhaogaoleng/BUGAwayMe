package com.example.bugawayme.util;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.example.bugawayme.R;

import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class WebSocketActivity extends AppCompatActivity {

            String TAG="BloodSugarActivity";
            public JWebSocketClient client;
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_web_socket);
            }

            @Override
            protected void onResume() {
                super.onResume();

                mHandler.postDelayed(heartBeatRunnable, HEART_BEAT_RATE);//开启心跳检测
                if (client == null) {
                    Log.e(TAG, "``````````````````````onResume");
                    initWebSocket();
                } else if (!client.isOpen()) {
                    reconnectWs();//进入页面发现断开开启重连
                }
            }

            @Override
            protected void onStop() {
                super.onStop();
                Log.e(TAG, "``````````````````````````````onStop");
            }

            @Override
            protected void onDestroy() {
                super.onDestroy();
                Log.e(TAG, "`````````````````````````onDestroy");
                closeConnect();
            }

            /**
             * 初始化websocket
             */
            public void initWebSocket() {
                //TODO
                //Log.e(TAG, "websocket的地址是：we://" + SpUtils.decodeString("websocketurl"));
                URI uri = URI.create("");
//                uri = URI.create("ws://" + SpUtils.decodeString("websocketurl"));
                //TODO 创建websocket
                client = new JWebSocketClient(uri) {
                    @Override
                    public void onMessage(String message) {
                        super.onMessage(message);
                        if (!message.equals("Heartbeat")){
                            Log.e(TAG, "websocket收到消息：" + message);
                        }
                    }

                    @Override
                    public void onOpen(ServerHandshake handshakedata) {
                        super.onOpen(handshakedata);
                         Log.e(TAG, "websocket连接成功");

                    }

                    @Override
                    public void onError(Exception ex) {
                        super.onError(ex);
                        Log.e(TAG, "websocket连接错误：" + ex);
                    }

                    @Override
                    public void onClose(int code, String reason, boolean remote) {
                        super.onClose(code, reason, remote);
                        if (code!=1000) {
                            reconnectWs();//意外断开马上重连
                        }
                        Log.d(TAG, "websocket断开连接：·code:" + code + "·reason:" + reason + "·remote:" + remote);
                    }
                };
                //TODO 设置超时时间
                client.setConnectionLostTimeout(110 * 1000);
                //TODO 连接websocket
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            //connectBlocking多出一个等待操作，会先连接再发送，否则未连接发送会报错
                            client.connectBlocking();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }

            /**
             * 发送消息
             */
            public void sendMsg(String msg) {
                if (null != client) {
                    Log.e("", "^_^Websocket发送的消息：" + msg);
                    if (client.isOpen()) {
                        client.send(msg);
                    }

                }
            }

            /**
             * 开启重连
             */
            private void reconnectWs() {
                mHandler.removeCallbacks(heartBeatRunnable);
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            Log.e("开启重连", "");
                            client.reconnectBlocking();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }

            /**
             * 断开连接
             */
            private void closeConnect() {
                try {
                    //关闭websocket
                    if (null != client) {
                        client.close();
                    }
                    //停止心跳
                    if (mHandler != null) {
                        mHandler.removeCallbacksAndMessages(null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    client = null;
                }
            }

            //websocket心跳检测
            private static final long HEART_BEAT_RATE = 10 * 1000;//每隔10秒进行一次对长连接的心跳检测
            private Handler mHandler = new Handler();
            private Runnable heartBeatRunnable = new Runnable() {
                @Override
                public void run() {
                    if (client != null) {
                        if (client.isClosed()) {
                            //Log.e("心跳包检测websocket连接状态1", client.isOpen() + "/" + SpUtils.decodeString("websocketurl"));
                            reconnectWs();//心跳机制发现断开开启重连
                        } else {
                            //Log.e("心跳包检测websocket连接状态2", client.isOpen() + "/" + SpUtils.decodeString("websocketurl"));
                            sendMsg("Heartbeat");
                        }
                    } else {
                        Log.e("心跳包检测websocket连接状态重新连接", "");
                        //如果client已为空，重新初始化连接
                        client = null;
                        //initSocketClient();
                    }
                    //每隔一定的时间，对长连接进行一次心跳检测
                    mHandler.postDelayed(this, HEART_BEAT_RATE);
                }
            };

    public void send(View view) {
        sendMsg("i from client");
    }
}


