/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package mArIoBuild.app;

import mArIoBuild.list.LinkedList;

import static mArIoBuild.utilities.StringUtils.join;
import static mArIoBuild.utilities.StringUtils.split;
import static mArIoBuild.app.MessageUtils.getMessage;

public class App {
    public static void main(String[] args) {
        LinkedList tokens;
        tokens = split(getMessage());
        System.out.println(join(tokens));
    }
}
