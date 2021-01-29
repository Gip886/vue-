<template>
  <div class="nav">
    <el-menu
      :default-active="this.$route.path"
      class="el-menu-demo"
      mode="horizontal"
      @select="handleSelect"
      router
    >
      <el-menu-item class="it" index=""
        ><a href="https://gip_jun.gitee.io/blog/" target="_blank"
          ><el-avatar :src="require('../assets/img/icon.jpg')"></el-avatar></a
      ></el-menu-item>
      <el-menu-item class="it" index="/">首页</el-menu-item>
      <el-menu-item class="it" index="/mysongs">我的音乐</el-menu-item>
      <el-menu-item class="it" index="/playlists">歌单</el-menu-item>
      <el-menu-item class="it" index="/Mvs">最新MV</el-menu-item>
      <el-menu-item class="it" index="/mymusic"
        >登录后查看添加歌曲</el-menu-item
      >
      <el-menu-item class="it"> <search-input></search-input></el-menu-item>
      <login class="login" v-show="!$store.state.isLogin"></login>
    </el-menu>

    <div class="loginOk" v-show="$store.state.isLogin">
      <img src="../assets/img/icon.jpg" alt="" />
      <el-dropdown @command="handleCommand">
        <span class="el-dropdown-link">
          成功登录{{ this.$store.state.userinfo
          }}<i class="el-icon-arrow-down el-icon--right"></i>
        </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item command="a">退出登录</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
    <el-backtop target=".nav"></el-backtop>
  </div>
</template>


<script>
import Login from "./Login.vue";
import SearchInput from "./SearchInput.vue";
export default {
  components: { SearchInput, Login },
  name: "top-bar",
  data() {
    return {
      activeIndex: "1",
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },
    handleCommand(command) {
      if (command == "a") {
        this.$store.commit("loginbackto");
        this.$message({
          message: "恭喜你，退出成功",
          type: "success",
        });
        return;
      }
      this.$message("click on item " + command);
    },
    backto() {
      this.$store.commit("loginbackto");
      this.$message({
        message: "恭喜你，退出成功",
        type: "success",
      });
    },
  },
};
</script>
<style scope>
.el-menu-demo {
  position: relative;
}
.el-menu-demo .it {
  z-index: 12;
}
.login {
  float: right;
  margin-right: 20px;
  margin-top: 10px;
}
.loginOk {
  position: absolute;
  top: 10px;
  right: 100px;
  z-index: 10;
}
.loginOk img {
  width: 40px;
  height: 40px;
}
</style>