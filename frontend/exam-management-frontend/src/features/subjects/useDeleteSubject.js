import { useMutation, useQueryClient } from "@tanstack/react-query"
import toast from "react-hot-toast";
import { deleteSubjectApi } from "../../services/apiSubjects";

export const useDeleteSubject = ()=> {
    const queryClient = useQueryClient();
    const {mutate:deleteSubject, isPending: isDeleting} = useMutation({
        mutationFn:deleteSubjectApi,
        onSuccess:()=>{
            queryClient.invalidateQueries({
                queryKey: ['subjects']
            })
            toast.success("Subject Deleted Successfully");
        },
        onError:()=> {
            toast.error("Subject not deleted")
        }
    })

    return {deleteSubject,isDeleting}
}