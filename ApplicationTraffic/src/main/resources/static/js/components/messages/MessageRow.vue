<template>
    <v-card class="my-2">
        <v-card-title class="align-end fill-height">
            <i>({{ message.id }})</i> &ensp; {{ message.text }}
        </v-card-title>
        <v-card-actions>
            <v-btn text outlined color="purple" @click="edit">
                Edit
            </v-btn>
            <v-btn icon @click="del">
                <v-icon>delete</v-icon>
            </v-btn>
        </v-card-actions>
    </v-card>
</template>
<script>
    import { mapActions } from "vuex";

export default {
        props: ['message', 'editMessage'],
        methods: {
            ...mapActions(['removeMessageAction']),
            edit() {
                this.editMessage(this.message)
            },
            del() {
                this.removeMessageAction(this.message)
            }
        }
    }
</script>

<style>
</style>
