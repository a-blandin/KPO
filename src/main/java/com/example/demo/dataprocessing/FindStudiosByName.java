package com.example.demo.dataprocessing;

import org.springframework.stereotype.Component;

@Component
public class FindStudiosByName {
    public Boolean NameEquals(String nameToFind, String nameFromList)
    {
        String [] nameToFindArray = nameToFind.split("");
        String [] nameFromListArray = nameFromList.split("");
        int counter = 0;

        for (int i = 0; i<nameFromListArray.length; i++)
        {
            if(nameToFindArray[i].equalsIgnoreCase(nameFromListArray[i]))
            {
                counter++;
            }
            else
            {
                counter--;
            }
            if (i==nameToFindArray.length-1)
            {
                break;
            }
        }
        return counter >= 3;
    }
}
