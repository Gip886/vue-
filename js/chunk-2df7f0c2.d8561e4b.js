(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2df7f0c2"],{"0ebb":function(t,a,s){"use strict";s.r(a);var i=function(){var t=this,a=t.$createElement,i=t._self._c||a;return i("div",{staticClass:"playlists-container"},[i("div",{staticClass:"top-card"},[i("div",{staticClass:"icon-wrap"},[i("img",{attrs:{src:t.goodlist.coverImgUrl,alt:""}})]),i("div",{staticClass:"content-wrap"},[i("div",{staticClass:"tag"},[t._v("精品歌单")]),i("div",{staticClass:"title"},[t._v(" "+t._s(t.goodlist.name)+" ")]),i("div",{staticClass:"info"},[t._v(" "+t._s(t.goodlist.description)+" ")])]),i("img",{staticClass:"bg",attrs:{src:t.goodlist.coverImgUrl,alt:""}}),i("div",{staticClass:"bg-mask"})]),i("div",{staticClass:"tab-container"},[i("div",{staticClass:"tab-bar"},[i("span",{staticClass:"item",class:{active:"全部"==t.tag},on:{click:function(a){t.tag="全部"}}},[t._v("全部")]),i("span",{staticClass:"item",class:{active:"欧美"==t.tag},on:{click:function(a){t.tag="欧美"}}},[t._v("欧美")]),i("span",{staticClass:"item",class:{active:"华语"==t.tag},on:{click:function(a){t.tag="华语"}}},[t._v("华语")]),i("span",{staticClass:"item",class:{active:"流行"==t.tag},on:{click:function(a){t.tag="流行"}}},[t._v("流行")]),i("span",{staticClass:"item",class:{active:"说唱"==t.tag},on:{click:function(a){t.tag="说唱"}}},[t._v("说唱")]),i("span",{staticClass:"item",class:{active:"摇滚"==t.tag},on:{click:function(a){t.tag="摇滚"}}},[t._v("摇滚")]),i("span",{staticClass:"item",class:{active:"民谣"==t.tag},on:{click:function(a){t.tag="民谣"}}},[t._v("民谣")]),i("span",{staticClass:"item",class:{active:"电子"==t.tag},on:{click:function(a){t.tag="电子"}}},[t._v("电子")]),i("span",{staticClass:"item",class:{active:"轻音乐"==t.tag},on:{click:function(a){t.tag="轻音乐"}}},[t._v("轻音乐")]),i("span",{staticClass:"item",class:{active:"影视原声"==t.tag},on:{click:function(a){t.tag="影视原声"}}},[t._v("影视原声")]),i("span",{staticClass:"item",class:{active:"ACG"==t.tag},on:{click:function(a){t.tag="ACG"}}},[t._v("ACG")]),i("span",{staticClass:"item",class:{active:"怀旧"==t.tag},on:{click:function(a){t.tag="怀旧"}}},[t._v("怀旧")])]),i("div",{staticClass:"tab-content"},[i("div",{staticClass:"items"},t._l(t.songslist,(function(a,c){return i("div",{key:c,staticClass:"item"},[i("div",{staticClass:"img-wrap"},[i("div",{staticClass:"num-wrap"},[t._v(" 播放量: "),i("span",{staticClass:"num"},[t._v(t._s(a.playCount))])]),i("img",{attrs:{src:a.coverImgUrl,alt:""}}),i("img",{staticClass:"iconfont icon-play",attrs:{src:s("1131"),alt:""}})]),i("p",{staticClass:"name"},[t._v(t._s(a.name))])])})),0)])]),i("el-pagination",{attrs:{background:"",layout:"prev, pager, next",total:t.total,"current-page":t.page,"page-size":12},on:{"current-change":t.handleCurrentChange}})],1)},c=[],n=s("bc3a"),l=s.n(n),e={name:"PlayLists",data:function(){return{total:0,page:1,goodlist:{},songslist:[],tag:"全部"}},watch:{tag:function(){this.getTopDate(),this.getListData(),this.page=1}},created:function(){this.getTopDate(),this.getListData()},methods:{handleCurrentChange:function(t){console.log("当前页: ".concat(t)),this.page=t,this.getListData()},getTopDate:function(){var t=this;l()({url:"https://autumnfish.cn/top/playlist/highquality",method:"get",params:{limit:2,cat:this.tag}}).then((function(a){t.goodlist=a.data.playlists[0]}))},getListData:function(){var t=this;l()({url:"https://autumnfish.cn/top/playlist/",method:"get",params:{limit:12,offset:12*(this.page-1),cat:this.tag}}).then((function(a){t.total=a.data.total,t.songslist=a.data.playlists}))}}},o=e,g=(s("4a93"),s("2877")),r=Object(g["a"])(o,i,c,!1,null,null,null);a["default"]=r.exports},"441c":function(t,a,s){},"4a93":function(t,a,s){"use strict";s("441c")}}]);
//# sourceMappingURL=chunk-2df7f0c2.d8561e4b.js.map