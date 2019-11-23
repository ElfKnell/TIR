<template>
    <v-row>
        <v-col cols="12" sm="6" md="3">
            <v-text-field label="Write something" outlined v-model="text" >
            </v-text-field>
        </v-col>
        <v-col cols="12" sm="6">
            <v-btn outlined height="56px" x-large color="indigo" @click="save">
                Save
            </v-btn>
        </v-col>
    </v-row>
</template>

<script>
    import { mapActions } from "vuex";

    export default {
        props: ['messageAttr'],
        data() {
            return {
                text: '',
                id: ''
            }
        },
        watch: {
            messageAttr(newVal, oldVal) {
                this.text = newVal.text
                this.id = newVal.id;
            }
        },
        methods: {
            ...mapActions(['addMessageAction', 'updateMessageAction']),
            save() {

                const message = { id: this.id, text: this.text }

                if (this.id) {
                    this.updateMessageAction(message)
                } else {
                    this.addMessageAction(message)
                }
                this.text = '',
                this.id = ''
            }
        }
    }
</script>

<style>
</style>