
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ToDoListManager from "./components/listers/ToDoListCards"
import ToDoListDetail from "./components/listers/ToDoListDetail"

import UserManager from "./components/listers/UserCards"
import UserDetail from "./components/listers/UserDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/toDoLists',
                name: 'ToDoListManager',
                component: ToDoListManager
            },
            {
                path: '/toDoLists/:id',
                name: 'ToDoListDetail',
                component: ToDoListDetail
            },

            {
                path: '/users',
                name: 'UserManager',
                component: UserManager
            },
            {
                path: '/users/:id',
                name: 'UserDetail',
                component: UserDetail
            },



    ]
})
