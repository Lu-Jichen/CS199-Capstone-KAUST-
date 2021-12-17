<template>
  <el-container style="height: 1200px; border: 1px solid #eee">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
      <el-menu :default-openeds="['1', '2']">
        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-user"></i>User Info
          </template>
          <router-link :to="'/main'">
            <el-menu-item index="1-1">Personal Homepage</el-menu-item>
          </router-link>
          <router-link :to="'/myErrand'">
            <el-menu-item index="1-1">MyErrand</el-menu-item>
          </router-link>
          <router-link :to="'/myWork'">
            <el-menu-item index="1-1">MyWork</el-menu-item>
          </router-link>
        </el-submenu>
        <el-submenu index="2">
          <template slot="title">
            <i class="el-icon-menu"></i>Menu
          </template>
          <router-link :to="'/errandList'">
            <el-menu-item index="2-1">Errand List</el-menu-item>
          </router-link>
        </el-submenu>
      </el-menu>
    </el-aside>
    <el-container>
      <el-main>
        <el-header style="text-align: right; font-size: 12px">
          <el-dropdown>
            <div v-if="!edit">
              <i style="margin-right: 15px" :class="'el-icon-edit'" @click="edit = !edit"></i>
            </div>
            <div v-else>
              <i style="margin-right: 15px" :class="'el-icon-check'" @click="edit = !edit; editUserInfo() ">
              </i>
            </div>
<!--            <el-dropdown-menu slot="dropdown">-->
<!--              <el-dropdown-item>view</el-dropdown-item>-->
<!--              <el-dropdown-item>create</el-dropdown-item>-->
<!--              <el-dropdown-item>delete</el-dropdown-item>-->
<!--            </el-dropdown-menu>-->
          </el-dropdown>
          <span>Operation</span>
        </el-header>
        <el-card align="left">
          Username:  {{username}}
        </el-card>
<!--        <el-card align="left" v-show="!edit">-->
<!--          Username:  {{userInfo['username']}}-->
<!--        </el-card>-->
<!--        <el-card v-show="edit">-->
<!--          <el-input  v-model="userInfo.username">-->
<!--          </el-input>-->
<!--        </el-card>-->

        <el-card align="left" v-show="!edit">
          Gender:  {{userInfo['genderDes']}}
        </el-card>
        <el-card v-show="edit">
          <el-input  v-model="userInfo.genderDes">
          </el-input>
        </el-card>

        <el-card align="left" v-show="!edit">
          Birthday:  {{userInfo['birthday']}}
        </el-card>
        <el-card v-show="edit">
          <el-input  v-model="userInfo.birthday">
          </el-input>
        </el-card>

        <el-card align="left" v-show="!edit">
          Phone Number:  {{userInfo['phoneNumber']}}
        </el-card>
        <el-card v-show="edit">
          <el-input  v-model="userInfo.phoneNumber">
          </el-input>
        </el-card>

        <el-card align="left" v-show="!edit">
          Location:  {{userInfo['location']}}
        </el-card>
        <el-card v-show="edit">
          <el-input  v-model="userInfo.location">
          </el-input>
        </el-card>

        <el-card align="left" v-show="!edit">
          Bank Account:  {{userInfo['bankAccount']}}
        </el-card>
        <el-card v-show="edit">
          <el-input  v-model="userInfo.bankAccount">
          </el-input>
        </el-card>
<!--        <i :class="{'el-icon-edit': !edit, 'el-icon-check': edit}" @click="edit = !edit" ></i>-->
      </el-main>
    </el-container>
  </el-container>
</template>
<style>
.el-header {
  background-color: #b3c0d1;
  color: #333;
  line-height: 60px;
}
.el-aside {
  color: #333;
}
</style>
<script>
import Cookies from 'js-cookie'
export default {
  name: 'UserIndex',
  data () {
    return {
      username: Cookies.get('username'),
      userInfo: null,
      pageNum: 1,
      total: 0,
      pageSize: 5,
      edit: false,
      description: 'Hello'
    }
  },
  mounted () {
    this.page(1)
  },
  methods: {
    page (pageNum) {
      const _this = this
      this.$axios.post('/userInfo', {
        // eslint-disable-next-line no-undef
        userId: Cookies.get('userId')
      }).then((res) => {
        _this.userInfo = res.data.data
        // _this.BTCinUSD = res.data.data.username
      })
    },
    handleClick (e, scope) {
      this.$router.push({ path: '/main', query: { id: scope.row.id } })
    },
    // eslint-disable-next-line vue/no-dupe-keys
    editUserInfo () {
      this.$axios.post('/userInfo/edit', {
        userId: Cookies.get('userId'),
        username: this.userInfo.username,
        genderDes: this.userInfo.genderDes,
        birthday: this.userInfo.birthday,
        phoneNumber: this.userInfo.phoneNumber,
        location: this.userInfo.location,
        bankAccount: this.userInfo.bankAccount
      }).then((res) => {
      })
    }
  }
}
</script>
