<template>
    <v-card outlined>
        <v-card-title>
            ManageMenu
        </v-card-title>

        <v-card-text>
            <String label="MenuName" v-model="value.menuName" :editMode="editMode"/>
            <Money offline label="Price" v-model="value.price" :editMode="editMode" @change="change"/>
            <String label="StockStatus" v-model="value.stockStatus" :editMode="editMode"/>
            <String label="Availability" v-model="value.availability" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="manageMenu"
            >
                ManageMenu
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'ManageMenuCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.menuName = '';
            this.value.price = {};
            this.value.stockStatus = '';
            this.value.availability = '';
        },
        watch: {
        },
        methods: {
            manageMenu() {
                this.$emit('manageMenu', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

