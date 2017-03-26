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
        }

    }


    /**
     * Loops through Cache array and looks for a slot with an 'invalid' tag
     * If all tags are valid (no '0' values), then it will replace the first slot
     * @param in_add
     * @param in_value
     */
    public void addToCache(short in_add, short in_value)
    {
            if (!Cache[in_add].isValid()) // if tag is not valid (aka empty)
            {
                Cache[in_add] = new CacheObj(in_add, in_value);
            }
        }

    public boolean inCache(short in_add)
    {
        short offset = (short)(in_add & 0x0000000F);
        short begin_addr = (short)(in_add & 0x000000F0);
        int tag = in_add >>> 8;
        int slot_num = (in_add & 0x000000F0) >>> 4;

        if (Cache[slot_num].isValid() && Cache[slot_num].getTag() == tag)
        {
        }

    }

}


