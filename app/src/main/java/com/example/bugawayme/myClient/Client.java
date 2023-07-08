package com.example.bugawayme.myClient;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bugawayme.R;
import com.google.android.material.snackbar.Snackbar;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.Date;

public class Client extends AppCompatActivity implements View.OnClickListener {


    private TextView showMessage;
    private EditText editText;
    private WebSocketClient webSocketClient;
    private StringBuilder sb = new StringBuilder();

    private String uriStr;

    //Handler 消息传递机制,主要是子线程UI更细消息传递给主线程，从而主线程更新UI。
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            sb.append("服务器返回数据：");
            sb.append(msg.obj.toString());
            sb.append("\n");
            showMessage.setText(sb.toString());
            return true;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showMessage = findViewById(R.id.show_message);
        editText = findViewById(R.id.edit_text);
        findViewById(R.id.send).setOnClickListener(this);
        //
        URI serverURI = URI.create(uriStr);
        webSocketClient = new WebSocketClient(serverURI) {
            @Override
            public void onOpen(ServerHandshake handshakedata) {
                sb.append("onOpen at time：");
                sb.append(new Date());
                sb.append("服务器状态：");
                sb.append(handshakedata.getHttpStatusMessage());
                sb.append("\n");
                showMessage.setText(sb.toString());
            }
            @Override
            public void onMessage(String message) {
                Message handlerMessage = Message.obtain();
                handlerMessage.obj = message;
                handler.sendMessage(handlerMessage);
            }
            @Override
            public void onClose(int code, String reason, boolean remote) {
                sb.append("onClose at time：");
                sb.append(new Date());
                sb.append("\n");
                sb.append("onClose info:");
                sb.append(code);
                sb.append(reason);
                sb.append(remote);
                sb.append("\n");
                showMessage.setText(sb.toString());
            }

            @Override
            public void onError(Exception ex) {
                sb.append("onError at time：");
                sb.append(new Date());
                sb.append("\n");
                sb.append(ex);
                sb.append("\n");
                showMessage.setText(sb.toString());
            }
        };
        webSocketClient.connect();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send:
                if(webSocketClient.isClosed() || webSocketClient.isClosing()){
                    Snackbar.make(v,"Client正在关闭",Snackbar.LENGTH_SHORT).show();
                    webSocketClient.connect();
                    break;
                }
                webSocketClient.send(editText.getText().toString().trim());
                sb.append("客户端发送消息：");
                sb.append(new Date());
                sb.append("\n");
                sb.append(editText.getText().toString().trim());
                sb.append("\n");
                showMessage.setText(sb.toString());
                editText.setText("");
                break;
            default:
                break;
        }
    }
}

