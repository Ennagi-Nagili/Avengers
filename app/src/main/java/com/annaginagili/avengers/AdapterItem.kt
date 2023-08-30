package com.annaginagili.avengers

import android.net.Uri

class AdapterItem {
    var name: String? = null
    var realName: String? = null
    var team: String? = null
    var firstAppearance: String? = null
    var createdBy: String? = null
    var publisher: String? = null
    var imageUrl: Uri? = null
    var bio: String? = null

    fun getData(names: ArrayList<String>, realNames: ArrayList<String>, teams: ArrayList<String>,
                firsts: ArrayList<String>, createds: ArrayList<String>, publishers: ArrayList<String>,
                images: ArrayList<Uri>, bios: ArrayList<String>): ArrayList<AdapterItem> {
        val itemList = ArrayList<AdapterItem>()
        for (i in 0 until names.size) {
            val item = AdapterItem()
            item.name = names[i]
            item.realName = realNames[i]
            item.team = teams[i]
            item.firstAppearance = firsts[i]
            item.createdBy = createds[i]
            item.publisher = publishers[i]
            item.imageUrl = images[i]
            item.bio = bios[i]
            itemList.add(item)
        }
        return itemList
    }
}