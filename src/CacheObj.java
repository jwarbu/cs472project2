import java.lang.reflect.Array;

/**
 * Created by jwartick on 3/25/17.
 */
public class CacheObj
{
    int valid_flag;
    int tag;
    int address;
    int offset;
    int begin_addr;
    int slot_num;
    int[] data_block = new int[16]; // default values should be 0


    public CacheObj() //constructor
    {
        valid_flag = 0;
        tag = 0;
        address = 0;
        offset = 0;
        begin_addr = 0;
        slot_num = 0;
    }

    public CacheObj(int in_add)
    {
        processAddress(in_add);
        grabBlock(begin_addr);
        valid_flag = 1;

    }

    public void setData(int in_val)
    {
        data_block[offset] = in_val;

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

    public void setValidFlag(int i)
    {
        valid_flag = i;
    }

    public int getValidFlag()
    {
        return valid_flag;
    }

    public void setAddress(int s)
    {
        address = s;
    }

    public int getAddress()
    {
        return address;
    }


    public void setTag(int i)
    {
        tag = i;
    }

    public int getTag()
    {
        return tag;
    }

    public void setOffset(int o)
    {
        offset = o;
    }

    public int getOffset()
    {
        return offset;
    }

    public void setBeginAddr(int b)
    {
        begin_addr = b;
    }

    public int getBeginAddr()
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

    public void grabBlock(int block_begin_addr)
    {
        for(int i = 0; i<=0xF; i++)
        {
            data_block[i] = block_begin_addr + i;
        }
    }

    public void processAddress(int in_add)
    {
        address = in_add;
        offset = in_add & 0x0000000F;
        begin_addr = in_add & 0x000000F0;
        tag = in_add >>> 8;
        slot_num = (in_add & 0x000000F0) >>> 4;

    }

    public void debugAddress()
    {
        offset = (int)(address & 0x0000000F);
        begin_addr = (int)(address & 0x000000F0);
        tag = address >>> 8;
        slot_num = (int)((address & 0x000000F0) >>> 4);
        System.out.println("address: " + Integer.toHexString(address));
        System.out.println("block offset: " + Integer.toHexString(offset));
        System.out.println("begin address: " + Integer.toHexString(begin_addr));
        System.out.println("tag: " + Integer.toHexString(tag));
        System.out.println("slot num: " + Integer.toHexString(slot_num));

    }

    public int findValue(int in_offset)
    {
        return (data_block[in_offset]);
    }

    public void printDataBlock()
    {
        for(int i = 0; i<data_block.length;i++)
        {
            System.out.print(Integer.toHexString(data_block[i]) + " ");
        }
    }

}
