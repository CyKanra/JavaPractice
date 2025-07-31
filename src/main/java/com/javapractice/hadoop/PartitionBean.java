package com.javapractice.hadoop;

import org.apache.hadoop.io.Writable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @ClassName: PartitionBean
 * @Description:
 * @Author: Kanra
 * @Date: 2025/7/16
 */
public class PartitionBean implements Writable {

    private String id;         // 設備id
    private String model;      // 型番
    private String netIp;      // ネットIP
    private String usageTime;     // 使用時間（分など）

    //セッター
    public void setId(String id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setNetIp(String netIp) {
        this.netIp = netIp;
    }

    public void setUsageTime(String usageTime) {
        this.usageTime = usageTime;
    }

    @Override
    public String toString() {
        return id + " | " +
                model + " | " +
                netIp + " | " +
                usageTime;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(id);
        dataOutput.writeUTF(model);
        dataOutput.writeUTF(netIp);
        dataOutput.writeUTF(usageTime);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.id = dataInput.readUTF();
        this.model = dataInput.readUTF();
        this.netIp = dataInput.readUTF();
        this.usageTime = dataInput.readUTF();
    }
}
