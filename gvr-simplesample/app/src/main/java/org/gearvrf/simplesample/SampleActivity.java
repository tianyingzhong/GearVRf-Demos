/* Copyright 2015 Samsung Electronics Co., LTD
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gearvrf.simplesample;

import android.os.Bundle;

import org.gearvrf.GVRActivity;
import org.gearvrf.GVRAndroidResource;
import org.gearvrf.GVRCameraRig;
import org.gearvrf.GVRContext;
import org.gearvrf.GVRMain;
import org.gearvrf.GVRScene;
import org.gearvrf.GVRSceneObject;
import org.gearvrf.GVRTexture;

public class SampleActivity extends GVRActivity {

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setMain(new SampleMain());
    }

    private static class SampleMain extends GVRMain {
        @Override
        public void onInit(GVRContext gvrContext) {
            GVRScene scene = gvrContext.getMainScene();
            scene.setBackgroundColor(1, 1, 1, 1);

            GVRTexture texture = gvrContext.getAssetLoader().loadTexture(new GVRAndroidResource(gvrContext, R.drawable.gearvr_logo));

            // create a scene object (this constructor creates a rectangular scene
            // object that uses the standard texture shader
            GVRSceneObject sceneObject = new GVRSceneObject(gvrContext, 4.0f, 2.0f, texture);

            // set the scene object position
            sceneObject.getTransform().setPosition(0.0f, 0.0f, -3.0f);

            // add the scene object to the scene graph
            scene.addSceneObject(sceneObject);
        }
    }
}