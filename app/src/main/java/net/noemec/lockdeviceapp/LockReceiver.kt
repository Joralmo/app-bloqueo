package net.noemec.lockdeviceapp

import android.app.admin.DevicePolicyManager
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.widget.Toast

class LockReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        val policyManager = context.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
        val compName = ComponentName(context, MyDeviceAdminReceiver::class.java)

        if (policyManager.isAdminActive(compName)) {
            policyManager.lockNow()
        } else {
            Toast.makeText(context, "Permisos de administrador no habilitados", Toast.LENGTH_SHORT).show()
        }
    }
}