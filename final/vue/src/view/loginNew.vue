<template>
  <body id="login-page">
  <el-form className="login-container" label-position="center" label-width="0px">
    <h3 className="login_title">Login</h3>
    <el-form-item style="width: 200px" class="el">
      <el-input
        type="text"
        v-model="loginForm.username"
        auto-complete="off"
        placeholder="username"
      ></el-input>
    </el-form-item>
    <el-form-item style="width: 200px" class="el">
      <el-input
        type="password"
        v-model="loginForm.password"
        auto-complete="off"
        placeholder="password"
      ></el-input>
    </el-form-item>
    <el-form-item style="width: 100px" class="el">
      <el-button
        type="primary"
        style="width: 100%;  border: none"
        @click="login"
      >Login
      </el-button>
    </el-form-item>
    <el-form-item style="width: 100px" class="el">
      <el-button
        type="primary"
        style="width: 100%;  border: none"
        @click="register"
      >Register
      </el-button>
    </el-form-item>
  </el-form>
  </body>
</template>

<script>
import Cookies from 'js-cookie'
// import {setCookie,getCookie} from '../assets/cookie.js'
export default {
  name: 'Login',
  // mounted(){
  //   /*页面挂载获取cookie，如果存在username的cookie，则跳转到主页，不需登录*/
  //   if(getCookie('username')){
  //     this.$router.push('/home')
  //   }
  // },
  data () {
    return {
      loginForm: {
        username: '',
        password: ''
      },
      responseResult: []
    }
  },
  // created () {
  //   this.loginForm.username = this.$route.params.id
  // },
  methods: {
    login () {
      this.$axios
        .post('/login', {
          username: this.loginForm.username,
          password: this.loginForm.password
        })
        .then(successResponse => {
          if (successResponse.data.code === 200) {
            Cookies.set('userId', successResponse.data.data, { expires: 300 })
            Cookies.set('username', this.loginForm.username, { expires: 300 })
            Cookies.set('password', this.loginForm.password, { expires: 300 })
            // alert(Cookies.get('userId'))
            // Cookies.set('password', encrypt(this.loginForm.password), { expires: 30 });
            // Cookies.set('rememberMe', this.loginForm.rememberMe, { expires: 30 });
            this.$router.replace({path: '/errandList'})
          } else {
            alert('Wrong username or password!')
          }
        })
        .catch(failResponse => {
        })
    },
    register () {
      this.$axios
        .post('/register', {
          username: this.loginForm.username,
          password: this.loginForm.password
        })
        .then(successResponse => {
          if (successResponse.data.code === 200) {
            this.$router.replace({path: '/login'})
            this.loginForm.username = ''
            this.loginForm.password = ''
          }
          alert(successResponse.data.message)
        })
        .catch(failResponse => {
        })
    }
  }
}
</script>

<style scoped>
#login-page {
  /*background: url("../assets/img/bg.jpg") no-repeat;*/
  background-position: center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
  align-items: center;
}

body {
  margin: 0px;
}

.login-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 90px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}

.login_title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}

.el {
  margin: 0px auto 10px auto;
  text-align: center;
  color: #505458;
}

</style>
