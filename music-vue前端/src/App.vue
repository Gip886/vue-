<template>
  <div id="app">
    <top-bar></top-bar>
    <router-view></router-view>
    <!-- <music-bar :musicdata="musicdata"></music-bar> -->
    <aplayer ref="aplayer"
      :audio="musicdata"
      fixed
      mini
      autoplay
      @onLoadeddata="play"
      @onPlay="play"
       @listSwitch="play"
    />
   
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

</style>

<script>
// import MusicBar from './components/MusicBar.vue'

import TopBar from "./components/TopBar.vue";
export default {
  data() {
    return {
      musicdata: [],
    };
  },
  watch:{
musicdata:function(){
  this.play()
}
  },
  methods: {
    play() {
      this.$refs.aplayer.play();
    },
  },
  components: { TopBar },
};
</script>
