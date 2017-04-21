package com.cxria.livetest.activity.photo;

/**
 * Created by yukun on 17-4-20.
 */
public class ImageDetail {
    private String ImagePath;
    private boolean isChecked;

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public boolean getChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    @Override
    public String toString() {
        return "ImageDetail{" +
                "ImagePath='" + ImagePath + '\'' +
                ", isChecked=" + isChecked +
                '}';
    }
}
