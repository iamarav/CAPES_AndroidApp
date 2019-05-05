package com.dozyapps.capes;

public class Questions {

    public String mQuestions[]= {
            "Who was the father of computer?",
            "What is the full form of ALU?",
            "Which is the correct name of a variable?\n(A) -var (B) var-1 (C) _var (D) var_1",
            "What type of declaration is it? \n unsigned num;",
            "Which statement does not require semicolon?",
            "INSERT, UPDATE and DELETE statements belong to",
            "What is Schema?",
            " Which module gives control of the CPU to the process selected by the short-term scheduler?",
            "Which one of the following can not be scheduled by the kernel?",
            "Process are classified into different groups in"};

    private String mChoices[][]= {
            {"Charlie Babbage","Dennis Ritchie","Charles Babbage","Ken Thompson"},
            {"Arithmetic Logic Unit","Arithmetic Local Unit","Advance Logical Unit","None of these"},
            {"Only (A)","Only (B)","Both (A) and (B)","Both (C) and (D)",},
            {"num is an unsigned integer.","num is an unsigned character.","num is an unsigned float","It’s an invalid declaration."},
            {"goto xyz","int x=20","#define MAX 1000","do{ ... }while(count<=100)e"},
            {"DQL Language","DDL Language","DCL Language","DML Language"},
            {"To identify the record uniquely","To normalize the database","Overall description of the database","To reduce data redundancy"},
            {"dispatcher","interrupt","scheduler","None of these"},
            {"kernel level thread","user level thread","none of the mentioned","process"},
            {"shortest job scheduling algorithm","round robin scheduling algorithm","priority scheduling algorithm","multilevel queue scheduling algorithm"}
    };

    private String mCorrectAnswers[] = {"Charles Babbage","Arithmetic Logic Unit","Both (C) and (D)","num is an unsigned integer.","#define MAX 1000","DML Language","Overall description of the database","dispatcher","user level thread","multilevel queue scheduling algorithm"};

public String getQuestion(int n){
        String question = mQuestions[n];
        return question;
        }

public String getChoice1(int n){
        String choice = mChoices[n][0];
        return choice;
        }

public String getChoice2(int n){
        String choice = mChoices[n][1];
        return choice;
        }
public String getChoice3(int n){
        String choice = mChoices[n][2];
        return choice;
        }
public String getChoice4(int n){
        String choice = mChoices[n][3];
        return choice;
        }
public String getCorrectAnswer(int n){
        String answer = mCorrectAnswers[n];
        return answer;
        }

        }
