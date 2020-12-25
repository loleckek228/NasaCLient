package com.example.nasaclient.navigation

import androidx.fragment.app.Fragment
import com.example.nasaclient.ui.earthphotos.EarthPhotosFragment
import com.example.nasaclient.ui.marsphotos.MarsPhotosFragment
import com.example.nasaclient.ui.menu.MenuFragment
import com.example.nasaclient.ui.spacephoto.SpacePhotoFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class MenuScreen : SupportAppScreen() {
        override fun getFragment(): Fragment? = MenuFragment()
    }

    class EarthPhotosScreen : SupportAppScreen() {
        override fun getFragment(): Fragment? = EarthPhotosFragment()
    }

    class MarsPhotosScreen : SupportAppScreen() {
        override fun getFragment(): Fragment? = MarsPhotosFragment()
    }

    class SpacePhotoScreen : SupportAppScreen() {
        override fun getFragment(): Fragment? = SpacePhotoFragment()
    }
}