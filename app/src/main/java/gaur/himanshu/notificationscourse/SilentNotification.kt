package gaur.himanshu.notificationscourse

import android.Manifest.permission.POST_NOTIFICATIONS
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat

fun silentNotification(context: Context){
    val notification = NotificationCompat.Builder(context, SILENT)
        .setSmallIcon(R.drawable.ic_launcher_background)
        .setContentTitle("title")
        .setContentText("description")
        .build()

    if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.TIRAMISU){
        if(ContextCompat.checkSelfPermission(context, POST_NOTIFICATIONS)== PackageManager.PERMISSION_GRANTED){
            NotificationManagerCompat.from(context)
                .notify(1,notification)
        }
    }else{
        NotificationManagerCompat.from(context)
            .notify(1,notification)
    }
}