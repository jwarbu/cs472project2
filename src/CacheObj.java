/**
 * Created by jwartick on 3/25/17.
 */
public class CacheObj
{
    int valid_flag;
    int tag;
    short address;
    short mem_value;
    short block_offset;
    short block_begin_addr;
    short slot_num;
    CacheObj[] Cache = new CacheObj[16];


    public CacheObj () //constructor
    {
        valid_flag = 0;
        tag = 0;
        address = 0;
        mem_value = 0;
        block_offset = 0;
        block_begin_addr = 0;
        slot_num = 0;

        // initialize Cache

        for(int i = 0; i<16; i++)
        {
            Cache[i] = new CacheObj();
        }

    }

    /**
     * receives an address and checks if it is in the Cache array
     * @param in_add
     *      user specified address
     * @return
     *      returns boolean flag; true if address is in the cache and flase if not
     */
    public boolean isInCache(short in_add)
    {
        boolean flag = false;
        for (CacheObj block: Cache)
        {
            if (block.isValid())
            {
                if (block.getAddress()==in_add)
                {
                    flag = true;
                }
            }

            else
            {
                flag = false;
            }
        }

        return flag;
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

    public void debugAddress()
    {
        block_offset = (short)(address & 0x0000000F);
        block_begin_addr = (short)(address & 0x000000F0);
        tag = address >>> 8;
        slot_num = (short)((address & 0x000000F0) >>> 4);
        System.out.println("address: " + Integer.toHexString(address));
        System.out.println("block offset: " + Integer.toHexString(block_offset));
        System.out.println("begin address: " + Integer.toHexString(block_begin_addr));
        System.out.println("tag: " + Integer.toHexString(tag));
        System.out.println("slot num: " + Integer.toHexString(slot_num));

    }

    public void setValue(short val)
    {
        mem_value = val;
    }

    public short getValue()
    {
        return mem_value;
    }

}
