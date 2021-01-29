<template>
  <div class="home">
    <!-- 返回首层定位 -->
      <el-backtop></el-backtop>
    <!--轮播图-->
    <card-img></card-img>

    <!--热门歌单-->
    <div class="section">
      <div class="section-title">歌单</div>
      <songs-list></songs-list>
      <!-- <content-list
        :contentList="songList"
        path="song-list-album"
      ></content-list> -->
    </div>
    <!--热门歌手-->
    <div class="section">
      <div class="section-title">最新音乐</div>
      <new-music></new-music>
      <!-- <content-list
        :contentList="singerList"
        path="singer-album"
      ></content-list> -->
    </div>
    <!-- 2020.12.27 -->
    <div class="section">
      <div class="section-title">推荐MV</div>
      <mv></mv>
      <!-- <content-list
        :contentList="singerList"
        path="singer-album"
      ></content-list> -->
    </div>
  </div>
</template>
<style scoped>
.home{
  margin-bottom: 50px;
}
.section {
  width: 100%;
  margin-top: 20px;
}

.section-title {
  height: 60px;
  line-height: 60px;
  padding-top: 10px;
  font-size: 28px;
  font-weight: 500;
  text-align: center;
  margin-bottom: 20px;
}
</style>


<script>
import CardImg from "../components/CardImg.vue";
import mv from "../components/MV.vue";

import NewMusic from "../components/NewMusic.vue";
import SongsList from "../components/songsList.vue";

export default {
  components: { CardImg, SongsList, 
  NewMusic, 
  mv },
};
</script>