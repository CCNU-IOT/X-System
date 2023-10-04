package com.example.harmonyapp01.slice;

import com.example.harmonyapp01.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.Text;
import ohos.eventhandler.EventHandler;
import ohos.eventhandler.EventRunner;
import ohos.eventhandler.InnerEvent;

import java.util.logging.Handler;

public class MainAbilitySlice extends AbilitySlice {

    private Button btn_region;
    private Text txt_data;
    private Button btn_refresh_data;
    Handler ui_handler;
    String sensor_id = "6500372502c946447751ea00_sensor";
    String data = "";

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        btn_region = (Button) findComponentById(ResourceTable.Id_btn_region);
        txt_data = (Text) findComponentById(ResourceTable.Id_txt_data);
        btn_refresh_data = (Button) findComponentById(ResourceTable.Id_btn_refresh_data);


        //刷新实时数据
        btn_refresh_data.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {


                //TODO:处理地区数据
                btn_region.setText("华中师范大学南湖校区");

                EventHandler handler = new EventHandler(EventRunner.getMainEventRunner()){
                    @Override
                    protected void processEvent(InnerEvent event) {
                         //更新数据到UI组件
                        txt_data.setText(data);
                    }
                };
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        httpGetHuaweiIOT iotController = null;
                        try {
                            iotController = new httpGetHuaweiIOT();
                            data = iotController.getdev(sensor_id,"shadow","radiation")+"μSv";

                            handler.sendEvent(InnerEvent.get());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });


    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
