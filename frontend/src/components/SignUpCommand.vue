<template>

    <v-card outlined>
        <v-card-title>
            SignUp
        </v-card-title>

        <v-card-text>
            <String label="Email" v-model="value.email" :editMode="editMode"/>
            <String label="Password" v-model="value.password" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="signUp"
            >
                SignUp
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
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
        name: 'SignUpCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.email = '';
            this.value.password = '';
        },
        watch: {
        },
        methods: {
            signUp() {
                this.$emit('signUp', this.value);
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

