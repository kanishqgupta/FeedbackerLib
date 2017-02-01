Feedbacker Library
===================


This Library Provide you to get user device information, when they provide feedback to you. 
----------


It Includes-
-------------
Lite Version (No Activity needed)

Activity Version (It will include activity to send feedback)

Rooted Status of device

Text feedback

Device Information

App version


Screenshot-
-------------
![Alt text](/github.png?raw=true "feedbacker Activity")

Minimum SDK-
-------------
#### <i class="icon-file"></i> 11


Download-
-------------
Gradle

    compile 'com.kanishq.feedbacker:feedbacker:0.1.2'

Maven

    <dependency>
      <groupId>com.kanishq.feedbacker</groupId>
       <artifactId>feedbacker</artifactId>
       <version>0.1.2</version>
       <type>pom</type>
    </dependency>
Using-
-------------
For Direct Use (This will directly open Mail app and add device information)

      feedbacker fd = new feedbacker();
                fd.deviceInf(getApplicationContext());
For Adding Email Address

     feedbacker.e= "your_email@abc.com"; //Replace with your Email


For Using With Activity

      Intent i = new Intent(MainActivity.this, feedbackerActivity.class);
                startActivity(i);

Don't Forget to add activity in Your Manifest

    <activity android:name="com.kanishq.feedbacker.feedbackerActivity" />
    





























































































































 















































































































































































































































































































































































































































































































































































































































































































































































































































































































