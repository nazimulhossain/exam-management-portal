import { useMutation, useQueryClient } from "@tanstack/react-query"
import toast from "react-hot-toast";
import { updateSubject } from "../../services/apiSubjects";

export const useEditSubject=()=>{
    const queryClient = useQueryClient();
    const{mutate:editSubject,isPending:isEditing} = useMutation({
        mutationFn:updateSubject,
        onSuccess: ()=>{
            queryClient.invalidateQueries({
                queryKey:['subjects']
            })

            toast.success("Subject updated successfully");
        },
        onError: ()=>{
            toast.error("Subject not updated");
        }
    });

    return {editSubject,isEditing}
}