import { useMutation, useQueryClient } from "@tanstack/react-query";
import toast from "react-hot-toast";
import { createSubject } from "../../services/apiSubjects";


export function useCreateSubject(){
    const queryClient = useQueryClient();

    const{mutate: createSubjectFn, isPending: isCreating } = useMutation({
        mutationFn: createSubject,
        onSuccess: ()=>{
            queryClient.invalidateQueries({
                queryKey: ['subjects']
            })
            toast.success("Subject created successfully");
        },

        onError: ()=> {
            toast.error("Subject not created");
        }
    })

    return {createSubjectFn,isCreating}
}