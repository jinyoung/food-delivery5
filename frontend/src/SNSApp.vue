

<template>
    <v-app id="inspire">
        <div>
            <v-app-bar color="primary" app clipped-left flat>
                <v-toolbar-title>
                    <span class="second-word font uppercase"
                        style="font-weight:700;"
                    >
                        <v-app-bar-nav-icon
                            @click="openSideBar()"
                            style="z-index:1;
                            height:56px;
                            width:30px;
                            margin-right:10px;
                            font-weight:300;
                            font-size:55px;"
                        >
                            <div style="line-height:100%;">≡</div>
                        </v-app-bar-nav-icon>
                    </span>
                </v-toolbar-title>
                <span v-if="urlPath!=null" 
                    class="mdi mdi-home" 
                    key="" 
                    to="/" 
                    @click="goHome()"
                    style="margin-left:10px; font-size:20px; cursor:pointer;"
		        ></span> 
                <v-spacer></v-spacer>

            </v-app-bar>

            <v-navigation-drawer app clipped flat v-model="sideBar">
                <v-list>
                    <v-list-item
                        class="px-2"
                        key="orders"
                        to="/fronts/orders"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        주문
                    </v-list-item>


                    <v-list-item
                        class="px-2"
                        key="orders"
                        to="/stores/orders"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        주문
                    </v-list-item>


                    <v-list-item
                        class="px-2"
                        key="orders"
                        to="/riders/orders"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        주문
                    </v-list-item>


                    <v-list-item
                        class="px-2"
                        key="orders"
                        to="/customers/orders"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        주문
                    </v-list-item>


                </v-list>
            </v-navigation-drawer>
        </div>

        <v-main>
            <v-container style="padding:0px;" v-if="urlPath" fluid>
                <router-view></router-view>
            </v-container>
            <v-container style="padding:0px;" v-else fluid>
                <div style="width:100%; margin:0px 0px 20px 0px; position: relative;">
                    <v-img style="width:100%; height:300px;"
                        src="https://oaidalleapiprodscus.blob.core.windows.net/private/org-IsZwoYj8yobpFySuytSuI26N/user-ha9EUDa76s1yoHT6JzgqOaFI/img-3AQBbCQiIk5ckDCfHt95I1DG.png?st=2023-07-11T23%3A41%3A31Z&se=2023-07-12T01%3A41%3A31Z&sp=r&sv=2021-08-06&sr=b&rscd=inline&rsct=image/png&skoid=6aaadede-4fb3-4698-a8f6-684d7786b067&sktid=a48cca56-e6da-484e-a814-9c849652bcb3&skt=2023-07-11T21%3A29%3A59Z&ske=2023-07-12T21%3A29%3A59Z&sks=b&skv=2021-08-06&sig=11qPCljpP//XHZCG9DMZ1ZmJIidIpfbeNS2sPZwQBh4%3D"
                    ></v-img>
                    <div class="App-main-text-overlap">음식배달서비스</div>
                    <div class="App-sub-text-overlap"></div>
                </div>
                <v-row>
                    <v-col cols="4" class="d-flex justify-center" v-for="(aggregate, index) in aggregates" :key="index">
                        <div 
                            class="flip-card"
                            @mouseover="flipCard(index)"
                            @mouseleave="unflipCard(index)"
                            :class="{ 'is-flipped': flipped[index] }"
                        >
                            <div class="flip-card-inner">
                                <div class="flip-card-front">
                                    <v-card
                                        class="mx-auto"
                                        style="width:300px; min-height: 310px; margin-bottom:20px; text-align: center; border-radius: 10px;"
                                        outlined
                                    >
                                        <v-list-item style="padding:15px; margin:0px;">
                                            <v-img style="width:100%; height:120px; border-radius: 10px;" :src="ImageUrl"></v-img>
                                        </v-list-item>
                                        <div style="text-align: left; padding:10px 15px 15px 15px; margin-top:-10px;">
                                            <h2>{{ aggregate.title }}</h2>
                                            <div>{{ aggregate.description }}</div>
                                        </div>
                                    </v-card>
                                </div>
                                <div class="flip-card-back">
                                    <v-card
                                        color="primary"
                                        class="mx-auto"
                                        style="width:300px; min-height: 310px; margin-bottom:20px; text-align: center; border-radius: 10px;"
                                        outlined
                                        :key="aggregate.key"
                                        :to="aggregate.route"
                                        @click="changeUrl()"
                                    >
                                        <v-list-item style="padding:15px; margin:0px;">
                                            <v-img style="height:120px; border-radius: 10px;" :src="ImageUrl"></v-img>
                                        </v-list-item>
                                        <h2 style="color:white;">{{ aggregate.title }} 관리</h2>
                                    </v-card>
                                </div>
                            </div>
                        </div>
                    </v-col>
                </v-row>
            </v-container>
        </v-main>
    </v-app>
</template>

<script>

export default {
    name: "App",
    data: () => ({
        useComponent: "",
        drawer: true,
        components: [],
        sideBar: true,
        urlPath: null,
        flipped: [],
        ImageUrl: 'https://oaidalleapiprodscus.blob.core.windows.net/private/org-IsZwoYj8yobpFySuytSuI26N/user-ha9EUDa76s1yoHT6JzgqOaFI/img-3AQBbCQiIk5ckDCfHt95I1DG.png?st=2023-07-11T23%3A41%3A31Z&se=2023-07-12T01%3A41%3A31Z&sp=r&sv=2021-08-06&sr=b&rscd=inline&rsct=image/png&skoid=6aaadede-4fb3-4698-a8f6-684d7786b067&sktid=a48cca56-e6da-484e-a814-9c849652bcb3&skt=2023-07-11T21%3A29%3A59Z&ske=2023-07-12T21%3A29%3A59Z&sks=b&skv=2021-08-06&sig=11qPCljpP//XHZCG9DMZ1ZmJIidIpfbeNS2sPZwQBh4%3D'
        aggregates: [
            { 
                title: '주문', 
                description: '고객이 메뉴를 선택하고 주문하는 과정을 담당하는 주문 액터', 
                key: 'orders', 
                route: '/fronts/orders',
            },
            { 
                title: '주문', 
                description: '주문을 수락하고 거절하는 상점 액터', 
                key: 'orders', 
                route: '/stores/orders',
            },
            { 
                title: '주문', 
                description: '주문을 배송하고 완료하는 라이더 액터', 
                key: 'orders', 
                route: '/riders/orders',
            },
            { 
                title: '주문', 
                description: '고객이 주문을 취소하는 액터', 
                key: 'orders', 
                route: '/customers/orders',
            },
            
        ],
    }),
    
    async created() {
      var path = document.location.href.split("#/")
      this.urlPath = path[1];

    },
    watch: {
        cards(newCards) {
            this.flipped = new Array(newCards.length).fill(false);
        },
    },

    mounted() {
        var me = this;
        me.components = this.$ManagerLists;
    },

    methods: {
        openSideBar(){
            this.sideBar = !this.sideBar
        },
        changeUrl() {
            var path = document.location.href.split("#/")
            this.urlPath = path[1];
            this.flipped.fill(false);
        },
        goHome() {
            this.urlPath = null;
        },
        flipCard(index) {
            this.$set(this.flipped, index, true);
        },
        unflipCard(index) {
            this.$set(this.flipped, index, false);
        },
    }
};
</script>
<style>
</style>
