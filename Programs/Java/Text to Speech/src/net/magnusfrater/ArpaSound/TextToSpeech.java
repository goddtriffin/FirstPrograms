package net.magnusfrater.ArpaSound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextToSpeech extends JFrame {

    //FRAME
    Dimension size = new Dimension(350,95);

    TestSpeak s;
    DatabaseFun df;

    //PANEL
    JTextField jtfInput;
    JButton jbInfo;
    String info =
            " CMUdict  --  Major Version: 0.07\n" +
            " ========================================================================\n" +
            " Copyright (C) 1993-2015 Carnegie Mellon University. All rights reserved.\n" +
            " \n" +
            " Redistribution and use in source and binary forms, with or without\n" +
            " modification, are permitted provided that the following conditions\n" +
            " are met:\n" +
            " \n" +
            "  1. Redistributions of source code must retain the above copyright\n" +
            "     notice, this list of conditions and the following disclaimer.\n" +
            "     The contents of this file are deemed to be source code.\n" +
            " \n" +
            "  2. Redistributions in binary form must reproduce the above copyright\n" +
            "     notice, this list of conditions and the following disclaimer in\n" +
            "     the documentation and/or other materials provided with the\n" +
            "     distribution.\n" +
            " \n" +
            " This work was supported in part by funding from the Defense Advanced\n" +
            " Research Projects Agency, the Office of Naval Research and the National\n" +
            " Science Foundation of the United States of America, and by member\n" +
            " companies of the Carnegie Mellon Sphinx Speech Consortium. We acknowledge\n" +
            " the contributions of many volunteers to the expansion and improvement of\n" +
            " this dictionary.\n" +
            " \n" +
            " THIS SOFTWARE IS PROVIDED BY CARNEGIE MELLON UNIVERSITY ``AS IS'' AND\n" +
            " ANY EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,\n" +
            " THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR\n" +
            " PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL CARNEGIE MELLON UNIVERSITY\n" +
            " NOR ITS EMPLOYEES BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,\n" +
            " SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT\n" +
            " LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,\n" +
            " DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY\n" +
            " THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT\n" +
            " (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE\n" +
            " OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.\n" +
            " \n" +
            " ========================================================================\n" +
            "\n" +
            "  NOTES\n" +
            "\n" +
            "- [20080401] (air)  New dict file format introduced\n" +
            "- comments (like this section) are allowed\n" +
            "- file name is major version; vers/rev information is now in the header\n";


    public TextToSpeech(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(size);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Text To Speech: by Todd Griffin");

        initComponents();

        s = new TestSpeak();
        df = new DatabaseFun();

        setVisible(true);
    }

    private void initComponents(){
        //panels
        JPanel center = new JPanel(new BorderLayout());
        JPanel bot = new JPanel();

        //center
        jtfInput = new JTextField();
        jtfInput.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                s.speak(jtfInput.getText());
            }
        });
        center.add(jtfInput);

        //bot
        jbInfo = new JButton("Info");
        jbInfo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                JOptionPane.showMessageDialog(new JFrame(), info);
            }
        });
        bot.add(jbInfo);

        //frame
        add(center,BorderLayout.CENTER);
        add(bot, BorderLayout.SOUTH);
    }

    public static void main(String[] args){
        TextToSpeech tts = new TextToSpeech();
    }
}