# java-
  为什么ListView的ViewHolder要声明为静态内部类？
  
      这个是考静态内部类和非静态内部类的主要区别之一。非静态内部类会隐式持有外部类的引用，
      就像大家经常将自定义的adapter在Activity类里，然后在adapter类里面是可以随意调用外
      部activity的方法的。当你将内部类定义为static时，你就调用不了外部类的实例方法了，
      因为这时候静态内部类是不持有外部类的引用的。声明ViewHolder静态内部类，可以将ViewHolder
      和外部类解引用。大家会说一般ViewHolder都很简单，不定义为static也没事吧。确实如此，
      但是如果你将它定义为static的，说明你懂这些含义。万一有一天你在这个ViewHolder加入一
      些复杂逻辑，做了一些耗时工作，那么如果ViewHolder是非静态内部类的话，就很容易出现内存泄露。
      如果是静态的话，你就不能直接引用外部类，迫使你关注如何避免相互引用。 
      所以将 ViewHolder内部类 定义为静态的，是一种好习惯
      
   进程间通信方式
   
      Intent
      Binder（AIDL）
      Messenger
      BroadcastReceiver
     Android系统中应用程序之间不能共享内存，在android SDK中提供了4种用于跨进程通讯的方式。
     这4种方式正好对应于android系统中4种应用程序组件：Activity、Content Provider、Broadcast和Service。
     http://blog.csdn.net/hedong316/article/details/50548399
