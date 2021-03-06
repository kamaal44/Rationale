package xyz.belvi.permissiondialog.Permission;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;

/**
 * Created by zone2 on 1/21/17.
 */

public class PermissionDetails {
    private String description, permission, rationaleMessage = "", deniedMessage = "";
    private int drawableResId;
    private int protectionLevel;

    public String getDescription() {
        return this.description;
    }

    public PermissionDetails setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getPermissionIcon() {
        return this.drawableResId;
    }

    public PermissionDetails setPermissionIcon(int drawable) {
        this.drawableResId = drawable;
        return this;
    }

    public String getRationaleMessage() {
        return this.rationaleMessage;
    }

    public PermissionDetails setRationaleMessage(String rationaleMessage) {
        this.rationaleMessage = rationaleMessage;
        return this;
    }

    public String getDeniedMessage() {
        return this.deniedMessage;
    }

    public PermissionDetails setDeniedMessage(String deniedMessage) {
        this.deniedMessage = deniedMessage;
        return this;
    }

    public String getPermission() {
        return this.permission;
    }

    public int getProtectionLevel() {
        return this.protectionLevel;
    }

    public PermissionDetails getPermissionDetails(Context context, String permission, int permissionDrawableResID) {
        PackageManager pm = context.getPackageManager();
        PermissionInfo info = null;
        try {
            info = pm.getPermissionInfo(permission, PackageManager.GET_META_DATA);
            String text = info.loadDescription(context.getPackageManager()).toString();
            this.permission = permission;
            this.description = text;
            this.protectionLevel = info.protectionLevel;
            this.drawableResId = permissionDrawableResID;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return this;
    }
}
