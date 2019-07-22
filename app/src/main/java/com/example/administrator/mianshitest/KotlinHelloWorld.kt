package com.example.administrator.mianshitest

import java.lang.Integer.parseInt

object KotlinHelloWorld {
    /**
     * java中不允许该方式嵌套
    /** kotlin中支持*/
     */

    /** var ：可变变量
     *  val ：不可变变量(类似Java中final修饰的变量，只能赋值一次)
     *
     *  $ 表示一个变量名或者变量值
     *  $varName 表示变量值
     *  ${varName.fun()} 表示变量的方法返回值:
     */
    @JvmStatic
    fun main(args: Array<String>) {
        //:Int 可省略,系统自动推断变量类型
        var a = 1
        val s1 = "a is $a" // a is 1
        a = 2
        val s2 = "${s1.replace("is", "was")}, but now is $a" //a was 1, but now is 2

        val b: Int//如果不在声明时初始化则必须提供变量类型


        if (args.size < 2) {
            print("Two integers expected")
            return
        }
        val x = parseInt(args[0])
        val y = parseInt(args[1])
        // 直接使用 `x * y` 会导致错误, 因为它们可能为 null.
        if (x != null && y != null) {
            // 在进行过 null 值检查之后, x 和 y 的类型会被自动转换为非 null 变量
            print(x * y)
        }
    }

    /**
     * 无返回值
     * noReturn ：自定义的方法名
     * a ：自定义的参数名
     * Int ：参数类型
     * :Unit ：可省略
     *println(a)=java中的 System.out.println(a)
     */
    fun noReturn(a: Int): Unit {
    }

    /**
     * 有返回值
     * :Int ：返回值类型
     */
    private fun sum1(a: Int, b: Int): Int {
        return a + b
    }

    /**
     * sum2和sum1相同
     * 还可以更简洁：fun sum2(a: Int, b: Int) = a + b
     */
    fun sum2(a: Int, b: Int): Int = a + b

    /**
     * vararg ：变长函数(类似java中 ...)
     * 下面代码等同于
     * public static void showStrs(int... strs){
     *   for(int i=0;i<strs.length;i++){
     *     System.out.println(strs[i]);
     *   }
     * }
     */
    fun vars(vararg v: Int) {
        for (vt in v) {
            print(vt)//vars(12345) 则输出 12345
        }
    }

    fun lambda() {
        val sumLambda: (Int, Int) -> Int = { x, y -> x + y }
        println(sumLambda(1, 2))//输出 3
    }

    fun getStringLength(obj: Any): Int? {
        if (obj is String) {
            // 做过类型判断以后，obj会被系统自动转换为String类型
            return obj.length
        }
        //在这里还有一种方法，与Java中instanceof不同，使用!is
         if (obj !is String){
         }
        // 这里的obj仍然是Any类型的引用
        return null
    }
}