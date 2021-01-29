<template>
  <div class="login">
    <el-button type="text" @click="outerVisible = true">登录|注册</el-button>

    <el-dialog title="登录" :visible.sync="outerVisible" center>
      <el-form :model="form1">
        <el-form-item label="用户名" :label-width="formLabelWidth">
          <el-input v-model="form.username" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" :label-width="formLabelWidth">
          <el-input v-model="form.password" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <el-dialog
        width="30%"
        title="注册"
        :visible.sync="innerVisible"
        append-to-body
        center
      >
        <!-- <el-input v-model="input" placeholder="请输入内容"></el-input> -->
        <el-form :model="form1">
          <el-form-item label="注册用户名" :label-width="formLabelWidth">
            <el-input v-model="form1.username" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="注册密码" :label-width="formLabelWidth">
            <el-input v-model="form1.password" autocomplete="off"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="logon">确 认 注 册</el-button>
        </div>
      </el-dialog>
      <div slot="footer" class="dialog-footer">
        <el-button @click="outerVisible = false">取 消</el-button>
        <el-button type="primary" @click="login">登录</el-button>
        <el-button @click="innerVisible = true">注册</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      outerVisible: false,
      innerVisible: false,
      form1: {
        username: "",
        password: "",
      },
      form: {
        username: "",
        password: "",
      },
      formLabelWidth: "120px",
    };
  },
  methods: {
    login() {
      axios({
        url:
          "http://localhost:8088/vue%E5%AE%9E%E8%AE%AD%E5%90%8E%E5%8F%B0/Login",
        method: "get",
        params: {
          username: this.form.username,
          password: this.form.password,
        },
      }).then((res) => {
        console.log(res);
        // alert(res.data);
        if (res.data.isLogin == "true") {
          let userinfo =[this.form.username,this.form.password]
          this.$store.commit("loginto");
          this.$store.commit("record",userinfo);
          this.form.username = "";
          this.form.password = "";
          this.form1.username = "";
          this.form1.password = "";
          this.outerVisible = false;
          this.$message({
            message: "恭喜你，登录成功",
            type: "success",
          });
        } else {
          this.$message.error("登陆失败");
          this.form.username = "";
          this.form.password = "";
          this.form1.username = "";
          this.form1.password = "";
        }
      });
    },
    logon() {
      if (this.form1.username == "" || this.form1.password == "") {
        this.$message.error("错了哦，输入不能为空哦");
      } else {
        axios({
          url:
            "http://localhost:8088/vue%E5%AE%9E%E8%AE%AD%E5%90%8E%E5%8F%B0/Res",
          method: "get",
          params: {
            username: this.form1.username,
            password: this.form1.password,
          },
        }).then((res) => {
          console.log(res);
          // alert(res.data);
          if (res.data.isRes == "true") {
            this.$message({
              message: "恭喜你，注册成功",
              type: "success",
            });
            this.form.username = "";
            this.form.password = "";
            this.form1.username = "";
            this.form1.password = "";
            this.innerVisible = false;
          } else {
            this.$message.error("很遗憾，注册失败！");
            this.form.username = "";
            this.form.password = "";
            this.form1.username = "";
            this.form1.password = "";
          }
        });

        // this.$message({
        //   message: "恭喜你，注册成功",
        //   type: "success",
        // });
        // this.innerVisible = false;
      }
    },
  },
};
</script>

<style scope>
</style>
