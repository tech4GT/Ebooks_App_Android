package com.codingblocks.codingblocks.models

import java.util.ArrayList
import java.util.HashMap

/**
 * Created by rishabhkhanna on 30/06/17.
 */
    fun generateList(groupList: ArrayList<String>, childList: HashMap<String, ArrayList<String>>) {
        groupList.add("Blocks of JS")
        groupList.add("Crux")
        groupList.add("Pandora")

        val child1 = ArrayList<String>()
        val child2 = ArrayList<String>()
        val child3 = ArrayList<String>()

        child1.add("Js")
        child1.add("Javascript")
        child1.add("weirdly stuff")
        child1.add("but go and learn JS")

        child2.add("YO")
        child2.add("all java here")
        child2.add("can be used to make android app")

        child3.add("God of Android ")
        child3.add("Here ")
        child3.add("and his warrior ")

        childList[groupList[0]] = child1
        childList[groupList[1]] = child2
        childList[groupList[2]] = child3

    }