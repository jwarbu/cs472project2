import java.lang.reflect.Array;

/**
 * Created by jwartick on 3/25/17.
 */
public class CacheObj
{
    int valid_flag;
    int tag;
    short address;
    short mem_value;
    short offset;
    short begin_addr;
    int slot_num;
    int[] data_block = new int[16]; // default values should be 0


    public CacheObj() //constructor
    {
        valid_flag = 0;
        mem_value = 0;
        tag = 0;
        address = 0;
        offset = 0;
        begin_addr = 0;
        slot_num = 0;
    }

    public CacheObj(short in_add, short in_val)
    {
        processAddress(in_add);
        valid_flag = 1;
        mem_value = in_val;

    }

    public boolean isValid()
    {
        boolean flag = false;
        if (valid_flag == 0)
        {
            flag = false;
        }

        if (valid_flag == 1)
        {
            flag = true;
        }

        return flag;
    }

    public void setAddress(short s)
    {
        address = s;
    }

    public short getAddress()
    {
        return address;
    }

    public void setValue(short val)
    {
        mem_value = val;
    }

    public short getValue()
    {
        return mem_value;
    }

    public void setTag(int i)
    {
        tag = i;
    }

    public int getTag()
    {
        return tag;
    }

    public void setOffset(short o)
    {
        offset = o;
    }

    public short getOffset()
    {
        return offset;
    }

    public void setBeginAddr(short b)
    {
        begin_addr = b;
    }

    public short getBeginAddr()
    {
        return begin_addr;
    }

    public void setSlotNum(int i)
    {
        slot_num = i;
    }

    public int getSlotNum()
    {
        return slot_num;
    }

    public int[] getDataBlock()
    {
        return data_block;
    }

    public void grabBlock(short block_begin_addr)
    {
        for(int i = 0; i<0xF; i++)
        {
            data_block[i] = block_begin_addr + i;
        }
    }

    public void processAddress(short in_add)
    {
        address = in_add;
        offset = (short)(in_add & 0x0000000F);
        begin_addr = (short)(in_add & 0x000000F0);
        tag = in_add >>> 8;
        slot_num = (in_add & 0x000000F0) >>> 4;

    }

    public void debugAddress()
    {
        offset = (short)(address & 0x0000000F);
        begin_addr = (short)(address & 0x000000F0);
        tag = address >>> 8;
        slot_num = (short)((address & 0x000000F0) >>> 4);
        System.out.println("address: " + Integer.toHexString(address));
        System.out.println("block offset: " + Integer.toHexString(offset));
        System.out.println("begin address: " + Integer.toHexString(begin_addr));
        System.out.println("tag: " + Integer.toHexString(tag));
        System.out.println("slot num: " + Integer.toHexString(slot_num));

    }


}
