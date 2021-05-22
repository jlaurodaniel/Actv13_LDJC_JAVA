package com.example.actv13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

interface interfaceClassByAlphabet {
     void anonMethodByAlphabet(ArrayList<String> lst);
}
interface interfaceClassByLength {
     void anonMethodByLength(ArrayList<String> lst);
}
class referencia {
    static void sortByAlphabet(ArrayList<String> lst){
        Collections.sort(lst);
    }
    static void sortByLength(ArrayList<String> lst){
        Collections.sort(lst, Comparator.comparing(String::length));
    }
}

public class Main {
public static ArrayList<String> list = new ArrayList<String>();
    public static void main(String[] args) {
        list.add("lauro");
        list.add("Miguel");
        list.add("Roman");
        list.add("Samanta");
        list.add("Pedro");
        list.add("Lourdes");
        list.add("Maria");
        list.add("Noelia");
        list.add("Ramon");
        list.add("Patricia");


        Collections.sort(list);
        Collections.sort(list, Comparator.comparing(String::length));
///Clases anonimas
        interfaceClassByAlphabet anonByAlphabet = new interfaceClassByAlphabet() {
            public void anonMethodByAlphabet(ArrayList<String>list) {
                Collections.sort(list);
            }
        };
        interfaceClassByLength anonByLength = new interfaceClassByLength() {
            public void anonMethodByLength(ArrayList<String>list) {
                Collections.sort(list, Comparator.comparing(String::length));
            }
        };

        //Expression lambda
        interfaceClassByAlphabet lambdaByAlphabet=(list)->Collections.sort(list);
        lambdaByAlphabet.anonMethodByAlphabet(list);
        interfaceClassByLength   lambdaByLength = (List-> Collections.sort(list, Comparator.comparing(String::length)));
        lambdaByLength.anonMethodByLength(list);

        //Método de referencia
        interfaceClassByAlphabet referenceByalphabet = referencia::sortByAlphabet;
        referenceByalphabet.anonMethodByAlphabet(list);
        interfaceClassByLength referenceByLength = referencia::sortByLength;
        referenceByLength.anonMethodByLength(list);
    }
}
