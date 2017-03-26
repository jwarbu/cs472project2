import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        short[] Main_mem = new short[2048];

    // initializing Main_mem
        short temp_initializer = 0;

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


        CacheObj cacheBlock = new CacheObj();

        cacheBlock.setAddress((short)0x000007ae);
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
                    short temp_add = keyboard.nextShort();
                    keyboard.nextLine();

                    if (cacheBlock.isInCache(temp_add))
                    {
                        System.out.println("Address: " + temp_add);
                        System.out.println("Cache Hit");

                    }

                    break;
                }

                case("W"): // write
                {
                    System.out.println("What address would you like to write to?");

                    break;
                }

                case("D"): // display
                {
                    System.out.println("Cache below: ");
                }
            }

        // take apart input

            // check if valid_flag

            // check if tag matches

        }


    }
}
