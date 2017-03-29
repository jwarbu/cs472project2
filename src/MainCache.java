/**
 * Created by jwartick on 3/26/17.
 */
public class MainCache
{
    CacheObj[] Cache = new CacheObj[16];

    public MainCache()
    {
        // initialize Cache

        for(int i = 0; i<16; i++)
        {
            Cache[i] = new CacheObj();
            Cache[i].setSlotNum(i);
        }

    }

    /**
     * Loops through Cache array and looks for a slot with an 'invalid' tag
     * If all tags are valid (no '0' values), then it will replace the first slot
     * @param in_add
     */
    public void addToCache(int in_add)
    {
        Cache[getSlot(in_add)] = new CacheObj(in_add);

    }

    public void writeValue(int in_add, int in_val)
    {
        Cache[getSlot(in_add)].setData(in_val);
    }

    public boolean inCache(int in_add)
    {
        boolean flag = false;

        int offset = in_add & 0x0000000F;
        int begin_addr = in_add & 0x000000F0;
        int tag = in_add >>> 8;
        int slot_num = (in_add & 0x000000F0) >>> 4;

        if (Cache[slot_num].isValid() && Cache[slot_num].getTag() == tag)
        {
            flag = true;
        }

        else
        {
            flag = false;
        }

        return flag;
    }

    public int checkCache(int in_add)
    {
        int returnVal;
        int offset = in_add & 0x0000000F;
        int begin_addr = in_add & 0x000000F0;
        int tag = in_add >>> 8;
        int slot_num = (in_add & 0x000000F0) >>> 4;

        if (Cache[slot_num].isValid() && Cache[slot_num].getTag() == tag)
        {
            returnVal = Cache[slot_num].findValue(offset);
        }

        else
        {
            returnVal = 0;
        }

        return returnVal;

    }

    public CacheObj findCacheObj(int in_add)
    {
        return(Cache[getSlot(in_add)]);
    }

    public int getSlot(int in_add)
    {
        int slot_num = (in_add & 0x000000F0) >>> 4;
        return slot_num;

    }

    public void prettyPrint()
    {
        for (int i = 0; i<16; i++)
        {
            System.out.print("  "+ Integer.toHexString(Cache[i].getSlotNum()) + "\t ");
            System.out.print("  "+Integer.toHexString(Cache[i].getValidFlag()) + "\t ");
            System.out.print("  "+Integer.toHexString(Cache[i].getTag()) + "\t ");
            System.out.print("\t\t");
            Cache[i].printDataBlock();
            System.out.println();
        }
    }
}


