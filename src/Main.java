import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        int[] Main_mem = new int[2048];

    // initializing Main_mem
        int temp_initializer = 0;

        for(int i = 0; i<2048; i++)
        {
            Main_mem[i] = temp_initializer;

            if (temp_initializer == 0xFF)
            {
                temp_initializer = -1;
            }

            temp_initializer++;
        }

        /** FOR DEBUGGING PURPOSES**/
        System.out.println("Array size: " + Main_mem.length);
        for(int i=0;i<2048;i++)
        {
            System.out.println(Integer.toHexString(i) + ": " + Integer.toHexString(Main_mem[i]));
        }
         //**/


        MainCache fullCache = new MainCache();
        CacheObj cacheBlock = new CacheObj();

        cacheBlock.setAddress(0x000007a2);
        cacheBlock.debugAddress();


        Menu menuOptions = new Menu();
        while (true)
        {
            menuOptions.displayMenu();

            switch(menuOptions.getChoice().toUpperCase())
            {
                case("R"): // read: check if address is in cache, Y: 'hit' return value
                {
                    System.out.println("What address would you like to read?");
                    int temp_add = Integer.parseInt(keyboard.nextLine(), 16);
                    int temp_val = fullCache.checkCache(temp_add);

                    //System.out.println(Integer.toHexString(temp_add));

                    if (temp_val != 0)
                    {
                        System.out.println();
                        System.out.println("Address: " + Integer.toHexString(temp_add));
                        System.out.println("Cache Hit!");
                        System.out.println("Value at " + Integer.toHexString(temp_add) + ": " + Integer.toHexString(temp_val));
                    }

                    else // was not in cache
                    {
                        fullCache.addToCache(temp_add);
                        System.out.println();
                        System.out.println("Address: " + Integer.toHexString(temp_add));
                        System.out.println("Cache Miss!");
                        System.out.println("Value at " + Integer.toHexString(temp_add) + ": " + Integer.toHexString(Main_mem[temp_add])); // show value found in Main_mem array

                    }

                    break;
                }

                case("W"): // write
                {
                    System.out.println("What address would you like to write to?");
                    int temp_add = Integer.parseInt(keyboard.nextLine(), 16);
                    System.out.println("What data would you like to write at that address?");
                    int user_val = Integer.parseInt(keyboard.nextLine(), 16);
                    int temp_val = fullCache.checkCache(temp_add); // check if valid

                    if (temp_val != 0) // aka cache hit
                    {
                        fullCache.writeValue(temp_add, user_val);
                        System.out.println();
                        System.out.println("Address: " + Integer.toHexString(temp_add));
                        System.out.println("Cache Hit!");
                        System.out.println("Value: " + Integer.toHexString(fullCache.checkCache(temp_add)));
                    }

                    else // was not in cache
                    {
                        fullCache.addToCache(temp_add);
                        fullCache.writeValue(temp_add, user_val);

                        System.out.println();
                        System.out.println("Address: " + Integer.toHexString(temp_add));
                        System.out.println("Cache Miss!");
                        System.out.println("Value: " + Integer.toHexString(fullCache.checkCache(temp_add))); // show value found in Main_mem array

                    }

                    break;
                }

                case("D"): // display
                {
                    System.out.println("Slot | Valid | Tag\t\tData");
                    fullCache.prettyPrint();
                }
            }

        // take apart input

            // check if valid_flag

            // check if tag matches

        }


    }
}
