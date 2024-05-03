import { useMutation, useQueryClient } from "@tanstack/react-query"
import { updateCourse } from "../../services/apiCourses";
import toast from "react-hot-toast";

export const useEditCourse=()=>{
    const queryClient = useQueryClient();
    const{mutate:editCourse,isPending:isEditing} = useMutation({
        mutationFn:updateCourse,
        onSuccess: ()=>{
            queryClient.invalidateQueries({
                queryKey:['courses']
            })

            toast.success("Course updated successfully");
        },
        onError: ()=>{
            toast.error("Course not updated");
        }
    });

    return {editCourse,isEditing}
}