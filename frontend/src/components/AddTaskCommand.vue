<template>

    <v-card outlined>
        <v-card-title>
            AddTask
        </v-card-title>

        <v-card-text>
            <String label="Title" v-model="value.title" :editMode="editMode"/>
            <Date label="Deadline" v-model="value.deadline" :editMode="editMode"/>
            <String label="Priority" v-model="value.priority" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="addTask"
            >
                AddTask
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
        name: 'AddTaskCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.title = '';
            this.value.deadline = '2023-05-19';
            this.value.priority = '';
        },
        watch: {
        },
        methods: {
            addTask() {
                this.$emit('addTask', this.value);
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

