package com.jetbrains.kmpapp.previews

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jetbrains.kmpapp.MR
import com.jetbrains.kmpapp.presentation.atomic.atoms.IconButtonAtom
import com.jetbrains.kmpapp.presentation.atomic.molecules.ButtonMolecule
import com.jetbrains.kmpapp.presentation.atomic.molecules.FieldType
import com.jetbrains.kmpapp.presentation.atomic.molecules.ShoppingItemMolecule
import com.jetbrains.kmpapp.presentation.atomic.molecules.TextFieldMolecule
import com.jetbrains.kmpapp.presentation.atomic.organisms.EmptyListOrganism
import com.jetbrains.kmpapp.presentation.atomic.organisms.TopBarOrganism
import dev.icerock.moko.resources.compose.painterResource

@Preview(showBackground = true)
@Composable
private fun EmptyListPreview() {
    EmptyListOrganism()
}

@Preview
@Composable
private fun TopBarPreview() {
    TopBarOrganism("Adicionar Item")
}

@Preview
@Composable
private fun IconButtonPreview() {
    IconButtonAtom(
        painter = painterResource(imageResource = MR.images.ic_back_arrow),
        onClick = { },
    )
}

@Preview(showBackground = true)
@Composable
private fun ShoppingItemPreview() {
    ShoppingItemMolecule(
        title = "Refrigerante",
        quantity = "6",
        onDeleteClick = {},
    )
}

@Preview
@Composable
private fun ButtonPreview() {
    ButtonMolecule(
        modifier = Modifier.fillMaxWidth(),
        label = "Criar",
        onClick = { /*TODO*/ },
    )
}

@Preview
@Composable
private fun ButtonLoadingPreview() {
    ButtonMolecule(
        modifier = Modifier.fillMaxWidth(),
        label = "Criar",
        onClick = { /*TODO*/ },
        loading = true,
    )
}

@Preview(showBackground = true)
@Composable
private fun TextFieldPreview() {
    TextFieldMolecule(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        label = "Text",
        onValueChange = {},
        value = ""
    )
}

@Preview(showBackground = true)
@Composable
private fun TextFieldPreviewNumeric() {
    TextFieldMolecule(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        label = "Number",
        onValueChange = {},
        value = "",
        type = FieldType.NUMERIC,
        maxLength = 2,
    )
}