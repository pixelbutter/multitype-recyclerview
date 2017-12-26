package pixelbuttertech.com.recyclerviewdemo

import android.app.AlertDialog
import android.app.Dialog
import android.app.DialogFragment
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast

class MessageDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val chefName: String? = savedInstanceState?.getString(EXTRA_CHEF_NAME) ?: arguments.getString(EXTRA_CHEF_NAME)

        val builder = AlertDialog.Builder(activity)
        builder.setMessage(getString(R.string.chef_message_dialog_title, chefName ?: getString(R.string.chef_generic)))
                .setPositiveButton(getString(R.string.chef_message_positive_action),
                        { di: DialogInterface, id: Int -> Toast.makeText(activity, getString(R.string.chef_message_sent_toast), Toast.LENGTH_LONG).show() })
                .setNegativeButton(getString(R.string.chef_message_negative_action), null)

        return builder.create()
    }

    companion object {
        fun newInstance(chefName: String): MessageDialogFragment {
            val fragment = MessageDialogFragment();
            val args = Bundle()
            args.putString(EXTRA_CHEF_NAME, chefName)
            fragment.arguments = args
            return fragment
        }

        const val EXTRA_CHEF_NAME = "extraChef"
    }
}