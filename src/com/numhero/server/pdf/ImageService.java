package com.numhero.server.pdf;

import com.google.appengine.api.images.Image;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.Transform;

import java.util.logging.Logger;

public class ImageService {
    private static final Logger log = Logger.getLogger(ImageService.class.getName());

    public static byte[] resizeImage(byte[] original, int maxWidth, int maxHeight) {
        ImagesService imagesService = ImagesServiceFactory.getImagesService();

        Image origImage = ImagesServiceFactory.makeImage(original);
        int origHeight = origImage.getHeight();
        int origWidth = origImage.getWidth();
        float widthRatio = (float) origWidth / (float) maxWidth;
        float heightRatio = (float) origHeight / (float) maxHeight;

        if (widthRatio > 1 || heightRatio > 1) {
            int newHeight = (int) (origHeight / heightRatio);
            int newWidth = (int) (origWidth / heightRatio);

            if (heightRatio < widthRatio) {
                newHeight = (int) (origHeight / widthRatio);
                newWidth = (int) (origWidth / widthRatio);
            }

            log.fine("Resizing an image from " + origWidth + "x" + origHeight + " to " + newWidth + "x" + newHeight);

            Transform resize = ImagesServiceFactory.makeResize(newWidth, newHeight);
            Image newImage = imagesService.applyTransform(resize, origImage);

            return newImage.getImageData();
        } else {
            return original;
        }
    }

}
