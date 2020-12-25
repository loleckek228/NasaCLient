package com.example.nasaclient.mvp.model.utils

import com.example.nasaclient.mvp.model.entity.local.RoomEarthPhoto
import com.example.nasaclient.mvp.model.entity.local.RoomMarsPhoto
import com.example.nasaclient.mvp.model.entity.local.RoomSpacePhoto
import com.example.nasaclient.mvp.model.entity.remote.EarthPhoto
import com.example.nasaclient.mvp.model.entity.remote.SpacePhoto
import com.example.nasaclient.mvp.model.entity.remote.marsphotos.MarsCamera
import com.example.nasaclient.mvp.model.entity.remote.marsphotos.MarsPhoto
import com.example.nasaclient.mvp.model.entity.remote.marsphotos.MarsPhotos

fun mapRoomEarthPhotosToEarthPhotos(roomPhotos: List<RoomEarthPhoto?>?): List<EarthPhoto> {
    val earthPhotos = mutableListOf<EarthPhoto>()

    roomPhotos!!.map {
        val photo = EarthPhoto(
            it!!.caption,
            it.date,
            it.image
        )

        earthPhotos.add(photo)
    }

    return earthPhotos
}

fun mapEarthPhotosToRoomEarthPhotos(earthPhotos: List<EarthPhoto?>): List<RoomEarthPhoto> {
    val roomPhotos = mutableListOf<RoomEarthPhoto>()

    earthPhotos.map {
        val roomPhoto = RoomEarthPhoto(
            it?.caption!!,
            it.date!!,
            it.image!!
        )

        roomPhotos.add(roomPhoto)
    }

    return roomPhotos
}

fun mapRoomMarsPhotosToMarsPhotos(roomPhotos: List<RoomMarsPhoto>): MarsPhotos {
    val marsPhotos = mutableListOf<MarsPhoto>()

    roomPhotos.map {
        val marsCamera = MarsCamera(it.camera)
        val photo = MarsPhoto(
            marsCamera,
            it.earth_date,
            it.img_src,
            it.sol
        )

        marsPhotos.add(photo)
    }

    return MarsPhotos(marsPhotos)
}

fun mapMarsPhotosToRoomMarsPhotos(marsPhotos: List<MarsPhoto>?): List<RoomMarsPhoto> {
    val roomPhotos = mutableListOf<RoomMarsPhoto>()

    marsPhotos?.map {
        val roomPhoto = RoomMarsPhoto(
            it.camera?.full_name!!,
            it.earth_date!!,
            it.img_src!!,
            it.sol!!
        )

        roomPhotos.add(roomPhoto)
    }

    return roomPhotos
}

fun mapRoomSpacePhotoToSpacePhoto(roomPhoto: RoomSpacePhoto): SpacePhoto {
    return SpacePhoto(
        roomPhoto.date,
        roomPhoto.explanation,
        roomPhoto.hdurl,
        roomPhoto.title
    )
}

fun mapSpacePhotoToRoomSpacePhoto(photo: SpacePhoto?): RoomSpacePhoto {
    return RoomSpacePhoto(
        photo?.date!!,
        photo.explanation!!,
        photo.hdurl!!,
        photo.title!!
    )
}