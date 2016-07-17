package nikhi.mysecondapplication;

/**
 * Created by nikhi on 6/18/16.
 */
public class User {
    String email;
    String password;
    int dishwasherloads;
    int meals;
    int squarefeetofusersgarden;
    int showerMinutes;
    int flushes;
    int laundryloads;
    int changed;

    String challengeBathroom;
    String challengeGarden;
    String challengeLaundry;
    String challengeKitchen;

    public User()
    {
        logic();
    }
    public void setUserEmailandPass(String userEmail, String userPassword)
    {
        email = userEmail;
        password = userPassword;
        dishwasherloads = 0;
        meals = 0;
        squarefeetofusersgarden = 0;
        showerMinutes = 0;
        flushes = 0;
        challengeBathroom = null;
        challengeGarden = null;
        challengeKitchen = null;
        challengeLaundry = null;
        changed = 0;


    }
    public String getEmail() {
        return email;
    }
    public void setDishWashes(int newNum)
    {
        dishwasherloads = newNum;
        System.out.println(dishwasherloads);
    }
    public int getFlushes()
    {
        return flushes;
    }

    public int getSquarefeetofusersgarden()
    {
        return squarefeetofusersgarden;
    }

    public int getShowerMinutes()
    {
        return showerMinutes;
    }

    public int  getDishwasherloads()
    {
        return dishwasherloads;
    }

    public int getMeals()
    {
        return meals;
    }

    public int getLaundryloads()
    {
        return laundryloads;
    }



    public void logic() {
        // please finish :) thanks call me at 408 - 242 - 6693
        //create strings for the challenges based on vars
        //BATHROOM CHALLENGE
        if (flushes <= 6 && flushes >=0)
        {
            challengeBathroom= "You are doing well with toilet use. Upgrade toilet for possible rebates \n";
        }
        else
        {
            challengeBathroom= "Decrease your toilet use and upgrade toilet for possible rebates \n";
        }
        if (showerMinutes >= 10)
        {
            challengeBathroom+= "Take 5-10 minute showers and upgrade your shower head";
        }
        else
        {
            challengeBathroom+= "You are doing well with showers. Upgrade shower head for possible rebates.";
        }

        //KITCHEN CHALLENGE


        if (meals * 1.76 <= 7)
        {
            challengeKitchen = "You are doing well with water use for cooking. Check the type of kitchen faucet for possible rebates \n";
        }
        else
        {
            challengeKitchen = "Decrease kitchen faucet use and consider upgrading your faucet \n";
        }

        if (dishwasherloads >= 2)
        {
            challengeKitchen+= "Consider decreasing use of dishwasher and highly consider upgrading your dishwasher for possible rebates";
        }
        else
        {
            challengeKitchen+= "Check your dishwasher model and consider upgrading your dishwasher for possible rebates.";
        }

        // LAUNDRY CHALLENGE

        if (laundryloads >=2)
        {
            challengeLaundry= "Consider upgrading your laundry machines and reduce your loads to around 2/week.";
        }
        else
            challengeLaundry= "You are doing well with your laundry. Consider upgrading your laundry machines for more saving.";

        //GARDEN CHALLENGE
        //because the tips are the same
        challengeGarden = "Consider making part of your lawn as artificial landscape to save money.";
    }

    public String getChallengeBathroom()
    {
        return challengeBathroom;
    }

    public String getChallengeLaundry()
    {
        return challengeLaundry;
    }

    public String getChallengeGarden()
    {
        return challengeGarden;
    }

    public String getChallengeKitchen()
    {
        return challengeKitchen;
    }

}
