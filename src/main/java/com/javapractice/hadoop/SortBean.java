package com.javapractice.hadoop;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @ClassName: SortBean
 * @Description:
 * @Author: Kanra
 * @Date: 2025/08/13
 */
public class SortBean implements WritableComparable<SortBean> {

    private String id;         // 設備id
    private String model;      // 型番
    private String netIp;      // ネットIP
    private Long usageTime;     // 使用時間（分など）

    public String getModel() {
        return model;
    }

    public Long getUsageTime() {
        return usageTime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setNetIp(String netIp) {
        this.netIp = netIp;
    }

    public void setUsageTime(Long usageTime) {
        this.usageTime = usageTime;
    }

    @Override
    public String toString() {
        return id + " " +
                model + " " +
                netIp + " " +
                usageTime;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(id);
        dataOutput.writeUTF(model);
        dataOutput.writeUTF(netIp);
        dataOutput.writeLong(usageTime);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.id = dataInput.readUTF();
        this.model = dataInput.readUTF();
        this.netIp = dataInput.readUTF();
        this.usageTime = dataInput.readLong();
    }

    @Override
    public int compareTo(SortBean sortBean) {
        String[] modelStr =sortBean.getModel().split("_");
        Long modelKey = Long.parseLong(modelStr[1]);
        String[] modelStr2 = model.split("_");
        Long modelKey2 =  Long.parseLong(modelStr2[1]);
        if (modelKey2 != modelKey)
            return Long.compare(modelKey2, modelKey);

        return Long.compare(usageTime, sortBean.getUsageTime());

    }
}
