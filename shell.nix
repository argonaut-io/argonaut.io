{ pkgs ? import <nixpkgs> {} }:

with pkgs;

stdenv.mkDerivation {
  name = "argonaut.io";

  buildInputs = [
    automake
    jekyll
    ruby
    simpleBuildTool
  ];
}