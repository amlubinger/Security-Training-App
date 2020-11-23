package com.example.securitytrainingapp.ui.learning;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.securitytrainingapp.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LearningFragment extends Fragment {

    private LearningViewModel learningViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        learningViewModel =
                ViewModelProviders.of(this).get(LearningViewModel.class);
        View root = inflater.inflate(R.layout.fragment_learning, container, false);
        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.article_card_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        //Get the articles in a list. Temporarily using just string arrays with mock data.
        List<String[]> articles = new ArrayList<String[]>();
        String[] articleOne = new String[3];
        articleOne[0] = "Creating a Secure Password";
        articleOne[1] = "Learn How to Create a Secure Password Through Several Tips.";
        articleOne[2] = "Creating and remembering a secure password is crucial when using today’s technology.  This article will serve to help you create a strong, secure, and memorable password.  First, avoid the key mistake of making your password related to an aspect of your life.  Avoid passwords that contain your pet’s name, your university, year you graduated, your favorite number, your child’s name, and your favorite sport’s team.  Passwords containing this information are easy to crack because almost all this information can be found on your social media page.  Programs exist that will easily crack passwords given this information.  Second, go beyond the usual password security requirements.  Most websites have you create a password that contains at least one uppercase character, one number, one lowercase character, one special character, and be at least eight characters in length.  The problem with this is that people usually follow the pattern of the first character being uppercase, followed by lowercase characters, and then ending the password with the number and special character.  Avoid this pattern by using several uppercase characters and special characters throughout the password.  For example, the password “b!rCh92tAb!e” is much more secure than “Birchtable92!”  Next, to be as secure as possible, it is now recommended that instead of using a password, a passphrase should be used.  This passphrase should be longer in length than a password and have little to no meaning to you.  An example passphrase is “TheBoatLeft74!ShoreAt!Dawn”  Finally, it is important to never reuse a password.  While this is easier said than done, this step is crucial because it prevents your secure information from multiple sites being accessed because one site got hacked.\n";

        String[] articleTwo = new String[3];
        articleTwo[0] = "Choosing an Anti-virus Program";
        articleTwo[1] = "Learn About the Various Available Anti-Virus Programs and Which One to Choose.";
        articleTwo[2] = "On your personal computer it is important to have an anti-virus or anti-malware program.  This article will go over the benefits of having a program like this on your computer, and discuss the important points to consider when choosing which program you want.  The first point to consider is price; think about your past experiences with computer viruses and your proficiency with computers.  If you consider yourself well experienced at safely navigating the web and have gotten few or no computer viruses, then the free version of an anti-virus software will be enough for you.  On the other hand, if you consider yourself less experienced with the internet and have had several computer viruses, then the paid version of an anti-virus is likely better for you.  The current most popular anti-virus and anti-malware programs are Norton, Kaspersky, McAfee, Windows Defender, Avast, and Malwarebytes.  Each of these programs offers a free version and a premium (paid) version.  The main difference between these two versions is that the paid version allows for real-time protection, meaning if you attempt to download a virus, the program will step in and prevent you from doing so.  The free versions only have a scanning option that lets you manually scan your computer for viruses and potentially unwanted programs.  Over the years I have used the free versions of each of the programs I have listed, from personal experience I liked Malwarebytes the best because it was able to find viruses that the other programs could not.  In my opinion, it does the best job of scanning your computer and contains the largest library for identifying viruses and malware; I personally use Malwarebytes on all of my computers.  With that being said, I would recommend visiting each program’s website to get a better understanding of each program, especially its price and business model.  Finally, after choosing one of these programs, I would recommend running a file scan each month to prevent viruses and potentially unwanted programs from remaining on your computer..\n";

        String[] articleThree = new String[3];
        articleThree[0] = "General Tips for Staying Safe Online";
        articleThree[1] = "Learn How to Stay Safe Online by Following Some Simple Tips";
        articleThree[2] = "The internet is a vast expanse of knowledge and useful resources; thus it makes sense that it also includes scammers and viruses trying to steal your money and data.  This article will provide you with tips and strategies to keep you safe while using the internet.  First, it is important to have an anti-virus or anti-malware program on your computer.  Please read the article “Choosing an Anti-virus Program” before continuing with this reading.  Second, it is important to take into account whose Wi-Fi network you are using, and what actions you are performing.  If you are on a public network like a coffee shop, avoid performing actions like paying off your credit card bill or logging into your bank account.  Hackers target public Wi-Fi networks because their security is usually subpar, allowing them to easily infiltrate its users’ traffic and steal their information (like passwords).  If it is necessary for you to perform actions like those on a public Wi-Fi network, you should use a Virtual Private Network (VPN).  VPNs provide a secure tunnel for your internet traffic, making it harder for hackers to view what you are doing on your computer.\n";

        String[] articleFour = new String[3];
        articleFour[0] = "Avoiding Phishing Emails";
        articleFour[1] = "Learn How to Avoid Getting Caught by Phishing Emails";
        articleFour[2] = "This article will teach you how to spot the common qualities of a phishing email.  A common way for hackers to get your passwords and other data is by sending you emails that appear to be from reputable companies, this is called phishing.  You can avoid becoming a victim of phishing emails by doing the following steps.  First, always look at the sender of an email; verify that the email you received is sent from the official, usual address.  Second, examine the email to make sure it seems official.  Hackers will often mimic a company’s email design incorrectly, be sure that there are no spelling mistakes and that the overall look of the email is official and tidy.  It can help to compare a newly received email with an email from that same company that you know is real.  Third, examine the content of the email.  Hackers will often ask you for your account username and/or password in the email itself.  This is an instant red flag that the email is a phishing attack.  Finally, examine the links that appear in an email.  Phishing emails will often contain links that take you to recreations of a login screen to steal your username and password.  Before clicking on a link, mouse over it by placing your cursor on it, your internet browser will then tell you where the link will take you if you were to click on it.  Examine the address and make sure that it seems official by ensuring that the link ends in a .com, .org, or any of the other usual domains.  If the link seems even slightly different from the usual address of the company’s website, do not click on it.\n";

        articles.add(articleOne);
        articles.add(articleTwo);
        articles.add(articleThree);
        articles.add(articleFour);

        ArticleCardAdapter adapter = new ArticleCardAdapter(articles);
        recyclerView.setAdapter(adapter);

        BottomSheetBehavior<View> bottomSheet = BottomSheetBehavior.from(root.findViewById(R.id.article));
        bottomSheet.setState(BottomSheetBehavior.STATE_HIDDEN);

        return root;
    }
}
