package br.com.ceiot.aula08

import android.content.ContentValues
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_node.*

/**
 * TODO (10) Criar uma segunda atividade para a tela de add um node.
 */
class AddNodeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_node)
    }

    /**
     * Salva o node.
     * @param view
     */
    fun onClickAddNode(view: View) {

        val name = name_editText.text
        val description = desc_editText.text

        if (name.length == 0) {
            Toast.makeText(this, "Name Empty", Toast.LENGTH_LONG)
            return
        } else if (description.length == 0) {
            Toast.makeText(this, "Description Empty", Toast.LENGTH_LONG)
            return
        }

        // Inserir dados por meio do contentProvider
        val contentValues = ContentValues()
        contentValues.put(NodeContract.Node.COLUMN_NAME, name.toString())
        contentValues.put(NodeContract.Node.COLUMN_DESCRIPTION, description.toString())

        val uri = contentResolver.insert(NodeContract.Node.CONTENT_URI, contentValues)

        if (uri != null) {
            Toast.makeText(baseContext, uri.toString(), Toast.LENGTH_LONG).show()
        }

        //Finaliza atividade e volta para a atividade principal.
        finish()
    }
}
